#!/usr/bin/env bash

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

resolve_maven() {
  if [ -x "./mvnw" ]; then
    echo "./mvnw"
    return 0
  fi

  if [ -x "$SCRIPT_DIR/mvnw" ]; then
    echo "$SCRIPT_DIR/mvnw"
    return 0
  fi

  if [ -x "$HOME/.sdkman/candidates/maven/current/bin/mvn" ]; then
    echo "$HOME/.sdkman/candidates/maven/current/bin/mvn"
    return 0
  fi

  if [ -x "/opt/homebrew/bin/mvn" ]; then
    echo "/opt/homebrew/bin/mvn"
    return 0
  fi

  if [ -x "/usr/local/bin/mvn" ]; then
    echo "/usr/local/bin/mvn"
    return 0
  fi

  if command -v mvn >/dev/null 2>&1; then
    command -v mvn
    return 0
  fi

  return 1
}

echo "Installing Maven archetypes from:"
echo "  $SCRIPT_DIR"
echo
echo "This script is safe to run multiple times."
echo "Existing local archetypes with the same groupId/artifactId/version will be reinstalled."
echo

ARCHETYPE_DIRS=()

while IFS= read -r pom_file; do
  archetype_dir="$(dirname "$pom_file")"
  ARCHETYPE_DIRS+=("$archetype_dir")
done < <(find "$SCRIPT_DIR" -type f -path "*/archetype/pom.xml" | sort)

if [ "${#ARCHETYPE_DIRS[@]}" -eq 0 ]; then
  echo "No Maven archetypes were found."
  echo
  echo "Expected structure:"
  echo "  rest/archetype/pom.xml"
  echo "  actionlet/archetype/pom.xml"
  echo "  etc/archetype/pom.xml"
  exit 1
fi

echo "Found ${#ARCHETYPE_DIRS[@]} archetype(s):"
for dir in "${ARCHETYPE_DIRS[@]}"; do
  echo "  - ${dir#$SCRIPT_DIR/}"
done

echo

for dir in "${ARCHETYPE_DIRS[@]}"; do
  echo "------------------------------------------------------------"
  echo "Installing archetype:"
  echo "  ${dir#$SCRIPT_DIR/}"
  echo "------------------------------------------------------------"

  (
    cd "$dir"

    MVN_CMD="$(resolve_maven)" || {
      echo "ERROR: Maven is not installed or not available."
      echo
      echo "Try one of these:"
      echo "  sdk install maven"
      echo "  brew install maven"
      echo
      echo "Then verify with:"
      echo "  mvn -version"
      exit 1
    }

    echo "Using Maven command:"
    echo "  $MVN_CMD"
    echo

    "$MVN_CMD" clean install
  )

  echo
done

echo "Updating local Maven archetype catalog..."

MVN_CMD="$(resolve_maven)" || {
  echo "ERROR: Maven is not installed or not available."
  exit 1
}

"$MVN_CMD" archetype:crawl

echo
echo "Done."
echo "All detected archetypes were installed into your local Maven repository:"
echo "  ~/.m2/repository"
echo
echo "You can now use them with:"
echo "  mvn archetype:generate"