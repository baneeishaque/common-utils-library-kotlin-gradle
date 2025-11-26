# GitHub Topics and Tags

This document provides recommended GitHub topics/tags for the **Common-Utils-Library-Kotlin-Gradle** repository, along with methods to add them.

## Recommended GitHub Topics

Based on a comprehensive analysis of this repository, the following topics are recommended:

### Primary Topics (Core Technologies)
| Topic | Reason |
|-------|--------|
| `kotlin` | Primary programming language |
| `kotlin-library` | This is a reusable Kotlin library |
| `gradle` | Build system used |
| `gradle-kotlin-dsl` | Uses Gradle Kotlin DSL for build configuration |
| `jvm` | Targets JVM platform |
| `java` | JVM interoperability (uses @JvmStatic annotations) |

### Feature/Functionality Topics
| Topic | Reason |
|-------|--------|
| `utility-library` | Provides various utility functions |
| `utils` | General utilities collection |
| `ktor` | Uses Ktor HTTP client |
| `ktor-client` | Specifically uses Ktor client for API calls |
| `kotlinx-serialization` | Uses kotlinx-serialization for JSON |
| `coroutines` | Uses kotlinx-coroutines |
| `datetime` | Provides DateTime manipulation utilities |
| `cli` | Provides command-line interface utilities |

### CI/CD Topics
| Topic | Reason |
|-------|--------|
| `github-actions` | Uses GitHub Actions for CI |
| `travis-ci` | Has Travis CI configuration |
| `azure-pipelines` | Has Azure Pipelines configuration |
| `jenkins` | Has Jenkinsfile |

### Development Environment Topics
| Topic | Reason |
|-------|--------|
| `gitpod` | Gitpod workspace configuration |
| `gitpod-ready` | Fully configured for Gitpod |

### Category Topics
| Topic | Reason |
|-------|--------|
| `library` | This is a reusable library |
| `utilities` | Provides utility functions |
| `helper-functions` | Contains helper/utility functions |

## Complete List of Recommended Topics

```
kotlin
kotlin-library
gradle
gradle-kotlin-dsl
jvm
java
utility-library
utils
ktor
ktor-client
kotlinx-serialization
coroutines
datetime
cli
github-actions
gitpod
gitpod-ready
library
```

**Note:** GitHub allows a maximum of 20 topics per repository.

---

## Methods to Add GitHub Topics

### Method 1: GitHub Web Interface (Manual)

1. Navigate to your repository on GitHub: https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Gradle
2. Click on the gear icon (⚙️) next to "About" on the right sidebar
3. In the "Topics" field, add each topic separated by spaces or commas
4. Click "Save changes"

### Method 2: GitHub CLI (`gh`)

The GitHub CLI provides a straightforward way to manage repository topics.

#### Install GitHub CLI (if not already installed)

```bash
# macOS
brew install gh

# Windows
winget install --id GitHub.cli

# Ubuntu/Debian
curl -fsSL https://cli.github.com/packages/githubcli-archive-keyring.gpg | sudo dd of=/usr/share/keyrings/githubcli-archive-keyring.gpg
echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/githubcli-archive-keyring.gpg] https://cli.github.com/packages stable main" | sudo tee /etc/apt/sources.list.d/github-cli-stable.list > /dev/null
sudo apt update
sudo apt install gh
```

#### Authenticate with GitHub

```bash
gh auth login
```

#### Add Topics Using GitHub CLI

```bash
# Add all recommended topics at once
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Gradle --add-topic kotlin --add-topic kotlin-library --add-topic gradle --add-topic gradle-kotlin-dsl --add-topic jvm --add-topic java --add-topic utility-library --add-topic utils --add-topic ktor --add-topic ktor-client --add-topic kotlinx-serialization --add-topic coroutines --add-topic datetime --add-topic cli --add-topic github-actions --add-topic gitpod --add-topic gitpod-ready --add-topic library
```

Or add topics individually:

```bash
gh repo edit --add-topic kotlin
gh repo edit --add-topic kotlin-library
gh repo edit --add-topic gradle
gh repo edit --add-topic gradle-kotlin-dsl
gh repo edit --add-topic jvm
gh repo edit --add-topic java
gh repo edit --add-topic utility-library
gh repo edit --add-topic utils
gh repo edit --add-topic ktor
gh repo edit --add-topic ktor-client
gh repo edit --add-topic kotlinx-serialization
gh repo edit --add-topic coroutines
gh repo edit --add-topic datetime
gh repo edit --add-topic cli
gh repo edit --add-topic github-actions
gh repo edit --add-topic gitpod
gh repo edit --add-topic gitpod-ready
gh repo edit --add-topic library
```

#### Remove Topics Using GitHub CLI

```bash
gh repo edit --remove-topic <topic-name>
```

#### View Current Topics

```bash
gh repo view --json repositoryTopics
```

### Method 3: GitHub REST API (cURL)

#### Get Current Topics

```bash
curl -L \
  -H "Accept: application/vnd.github+json" \
  -H "Authorization: Bearer <YOUR_TOKEN>" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/repos/Baneeishaque/Common-Utils-Library-Kotlin-Gradle/topics
```

#### Replace All Topics

```bash
curl -L \
  -X PUT \
  -H "Accept: application/vnd.github+json" \
  -H "Authorization: Bearer <YOUR_TOKEN>" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/repos/Baneeishaque/Common-Utils-Library-Kotlin-Gradle/topics \
  -d '{"names":["kotlin","kotlin-library","gradle","gradle-kotlin-dsl","jvm","java","utility-library","utils","ktor","ktor-client","kotlinx-serialization","coroutines","datetime","cli","github-actions","gitpod","gitpod-ready","library"]}'
```

Replace `<YOUR_TOKEN>` with your GitHub Personal Access Token (PAT) with `repo` scope.

### Method 4: GitHub GraphQL API

```graphql
mutation {
  updateRepository(input: {
    repositoryId: "<REPOSITORY_NODE_ID>"
    topicNames: [
      "kotlin",
      "kotlin-library",
      "gradle",
      "gradle-kotlin-dsl",
      "jvm",
      "java",
      "utility-library",
      "utils",
      "ktor",
      "ktor-client",
      "kotlinx-serialization",
      "coroutines",
      "datetime",
      "cli",
      "github-actions",
      "gitpod",
      "gitpod-ready",
      "library"
    ]
  }) {
    repository {
      repositoryTopics(first: 20) {
        nodes {
          topic {
            name
          }
        }
      }
    }
  }
}
```

To get the repository node ID:

```graphql
query {
  repository(owner: "Baneeishaque", name: "Common-Utils-Library-Kotlin-Gradle") {
    id
  }
}
```

### Method 5: Using Python with PyGithub

```python
from github import Github

# Create a GitHub instance using a personal access token
g = Github("<YOUR_TOKEN>")

# Get the repository
repo = g.get_repo("Baneeishaque/Common-Utils-Library-Kotlin-Gradle")

# Define the topics
topics = [
    "kotlin",
    "kotlin-library", 
    "gradle",
    "gradle-kotlin-dsl",
    "jvm",
    "java",
    "utility-library",
    "utils",
    "ktor",
    "ktor-client",
    "kotlinx-serialization",
    "coroutines",
    "datetime",
    "cli",
    "github-actions",
    "gitpod",
    "gitpod-ready",
    "library"
]

# Set the topics
repo.replace_topics(topics)

print(f"Topics updated successfully: {repo.get_topics()}")
```

### Method 6: Using JavaScript/Node.js with Octokit

```javascript
const { Octokit } = require("@octokit/rest");

const octokit = new Octokit({
  auth: "<YOUR_TOKEN>"
});

async function updateTopics() {
  const response = await octokit.repos.replaceAllTopics({
    owner: "Baneeishaque",
    repo: "Common-Utils-Library-Kotlin-Gradle",
    names: [
      "kotlin",
      "kotlin-library",
      "gradle",
      "gradle-kotlin-dsl",
      "jvm",
      "java",
      "utility-library",
      "utils",
      "ktor",
      "ktor-client",
      "kotlinx-serialization",
      "coroutines",
      "datetime",
      "cli",
      "github-actions",
      "gitpod",
      "gitpod-ready",
      "library"
    ]
  });
  
  console.log("Topics updated:", response.data.names);
}

updateTopics();
```

---

## Quick Reference Commands

### GitHub CLI - Add All Topics (Single Command)

```bash
gh repo edit Baneeishaque/Common-Utils-Library-Kotlin-Gradle \
  --add-topic kotlin \
  --add-topic kotlin-library \
  --add-topic gradle \
  --add-topic gradle-kotlin-dsl \
  --add-topic jvm \
  --add-topic java \
  --add-topic utility-library \
  --add-topic utils \
  --add-topic ktor \
  --add-topic ktor-client \
  --add-topic kotlinx-serialization \
  --add-topic coroutines \
  --add-topic datetime \
  --add-topic cli \
  --add-topic github-actions \
  --add-topic gitpod \
  --add-topic gitpod-ready \
  --add-topic library
```

### cURL - Replace All Topics

```bash
curl -L -X PUT \
  -H "Accept: application/vnd.github+json" \
  -H "Authorization: Bearer $GITHUB_TOKEN" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  https://api.github.com/repos/Baneeishaque/Common-Utils-Library-Kotlin-Gradle/topics \
  -d '{"names":["kotlin","kotlin-library","gradle","gradle-kotlin-dsl","jvm","java","utility-library","utils","ktor","ktor-client","kotlinx-serialization","coroutines","datetime","cli","github-actions","gitpod","gitpod-ready","library"]}'
```

---

## Topic Guidelines

- Topics should be lowercase
- Use hyphens for multi-word topics (e.g., `kotlin-library`)
- Maximum 20 topics per repository
- Topics help with repository discoverability
- Popular topics appear in GitHub Explore and searches
