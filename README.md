# Common Utils Library - Kotlin Gradle

<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-2.2.20-purple?logo=kotlin&logoColor=white" alt="Kotlin Version">
  <img src="https://img.shields.io/badge/Gradle-9.1.0-02303A?logo=gradle&logoColor=white" alt="Gradle Version">
  <img src="https://img.shields.io/badge/JVM-21-orange?logo=openjdk&logoColor=white" alt="JVM Version">
  <a href="https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Gradle/actions/workflows/gradle.yml"><img src="https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Gradle/actions/workflows/gradle.yml/badge.svg" alt="Build Status"></a>
  <img src="https://img.shields.io/badge/License-MIT-blue.svg" alt="License">
</p>

<p align="center">
  A comprehensive collection of reusable Kotlin utilities for building robust CLI and API applications. This library provides battle-tested utilities for date/time manipulation, environment configuration, API interactions, interactive command-line interfaces, and much more.
</p>

---

## 📋 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Architecture](#-architecture)
- [Installation](#-installation)
- [Quick Start](#-quick-start)
- [API Reference](#-api-reference)
- [Development Setup](#-development-setup)
- [Building & Testing](#-building--testing)
- [CI/CD Pipelines](#-cicd-pipelines)
- [Contributing](#-contributing)
- [License](#-license)

---

## ✨ Features

### Core Utilities
- **DateTime Utilities** - Comprehensive date/time manipulation with support for multiple formats
- **Input Validation** - Type-safe input parsing and validation utilities
- **Error Handling** - Standardized error message construction and handling patterns
- **List Operations** - Helper functions for common list operations

### API & HTTP Client
- **Ktor HTTP Client** - Pre-configured HTTP client with authentication, logging, and JSON serialization
- **GitHub Gist Integration** - Built-in support for GitHub Gist API interactions
- **API Response Handling** - Generic response handling with success/failure patterns

### CLI Framework
- **Interactive Menus** - Flexible command-line menu system with various prompt types
- **Subcommand Support** - Enhanced subcommand classes with common argument patterns
- **User Input Handling** - Interactive input utilities with validation

### Configuration Management
- **Environment Variables** - dotenv-kotlin integration for environment configuration
- **JSON Serialization** - kotlinx.serialization support for JSON file operations

### Data Models
- **Result Pattern** - `IsOkModel` and variants for type-safe result handling
- **Serializable Models** - Pre-defined serializable data models for common use cases

---

## 🛠 Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| **[Kotlin](https://kotlinlang.org/)** | 2.2.20 | Primary programming language |
| **[Gradle](https://gradle.org/)** | 9.1.0 | Build automation |
| **[JVM](https://openjdk.org/)** | 21 | Runtime environment |
| **[Ktor Client](https://ktor.io/)** | 2.3.13 | HTTP client framework |
| **[kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization)** | 1.9.0 | JSON serialization |
| **[kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines)** | 1.10.2 | Asynchronous programming |
| **[kotlinx-cli](https://github.com/Kotlin/kotlinx-cli)** | 0.3.6 | Command-line argument parsing |
| **[dotenv-kotlin](https://github.com/cdimascio/dotenv-kotlin)** | 6.5.1 | Environment variable management |
| **[Logback](https://logback.qos.ch/)** | 1.5.19 | Logging framework |
| **[JaCoCo](https://www.jacoco.org/jacoco/)** | - | Code coverage |

---

## 🏗 Architecture

```
common-lib/
└── src/main/kotlin/common/utils/library/
    ├── cli/
    │   └── sub_commands/           # CLI subcommand implementations
    │       ├── SubCommandEnhanced.kt
    │       ├── SubCommandEnhancedWithUserIdAsArgument.kt
    │       ├── SubCommandEnhancedWithUsernameAsArgument.kt
    │       └── ...
    ├── constants/
    │   └── ConstantsCommon.kt      # Shared constants
    ├── enums/
    │   ├── CommandLineApiMethodCommonArgumentsEnum.kt
    │   ├── EnvironmentFileEntryCommonEnum.kt
    │   ├── PatternQuestionAnswerTypesEnum.kt
    │   ├── TimePartManipulationEnum.kt
    │   └── TimePartSpecificationEnum.kt
    ├── models/
    │   ├── ChooseByIdResult.kt
    │   ├── CommonDataModel.kt
    │   ├── EnvironmentFileEntryModel.kt
    │   ├── GistResponseModel.kt
    │   └── IsOkModel.kt            # Result pattern models
    └── utils/
        ├── ApiUtilsCommon.kt       # API response handling
        ├── ApiUtilsInteractiveCommon.kt
        ├── ChooseUtilsInteractive.kt
        ├── CommandLinePrintMenu.kt  # CLI menu utilities
        ├── DateTimeUtils.kt        # Date/time manipulation
        ├── EnvironmentFileOperations.kt
        ├── ErrorUtils.kt           # Error message helpers
        ├── GistUtilsCommon.kt      # GitHub Gist integration
        ├── InputUtils.kt           # Input validation
        ├── JsonFileUtils.kt        # JSON file operations
        ├── ListUtils.kt            # List utilities
        ├── MysqlUtils.kt           # MySQL date format conversion
        └── ...
```

---

## 📦 Installation

### Prerequisites

- **Java Development Kit (JDK) 21** or higher
- **Gradle 9.x** (wrapper included)

### Using JitPack (Recommended)

Add the JitPack repository to your `build.gradle.kts`:

```kotlin
repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}
```

Add the dependency:

```kotlin
dependencies {
    implementation("com.github.Baneeishaque:Common-Utils-Library-Kotlin-Gradle:TAG")
}
```

Replace `TAG` with the desired release tag or commit hash.

### Building from Source

```bash
# Clone the repository
git clone https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Gradle.git

# Navigate to project directory
cd Common-Utils-Library-Kotlin-Gradle

# Build the project
./gradlew build
```

---

## 🚀 Quick Start

### DateTime Manipulation

```kotlin
import common.utils.library.utils.DateTimeUtils

// Get current date/time in standard format (dd/MM/yyyy HH:mm:ss)
val currentDateTime = DateTimeUtils.getCurrentNormalDateTimeInText()
println(currentDateTime) // Output: 26/11/2024 15:30:45

// Add days to a date
val futureDate = DateTimeUtils.addDaysToNormalDateTimeInText(
    dateTimeInText = "26/11/2024 09:00:00",
    days = 7
)

// Subtract hours from a date
val pastDateTime = DateTimeUtils.subtractHoursFromNormalDateTimeInText(
    dateTimeInText = "26/11/2024 15:30:00",
    hours = 3
)

// Reset time to 9:00:00
val resetDateTime = DateTimeUtils.resetTimeOnNormalDateTimeInTextToX(
    dateTimeInText = "26/11/2024 15:30:45"
)
```

### Result Pattern with IsOkModel

```kotlin
import common.utils.library.models.*

// Create a success result
val successResult: IsOkModel<String> = SuccessBasedOnIsOkModel(ownData = "Operation completed")

// Create a failure result
val failureResult: IsOkModel<String> = FailureBasedOnIsOkModel(ownError = "Something went wrong")

// Check result status
if (successResult.isOK) {
    println("Data: ${successResult.data}")
} else {
    println("Error: ${successResult.error}")
}
```

### Environment Configuration

```kotlin
import common.utils.library.utils.EnvironmentFileOperations
import io.github.cdimascio.dotenv.dotenv

val dotEnv = dotenv()

// Get environment variable with default value
val apiUrl = EnvironmentFileOperations.getEnvironmentVariableValueForTextWithDefaultValue(
    dotEnv = dotEnv,
    environmentVariableName = "API_URL",
    defaultValue = "http://localhost:8080"
)
```

### GitHub HTTP Client

```kotlin
import common.utils.library.utils.GistUtilsCommon

// Create authenticated HTTP client for GitHub API
val httpClient = GistUtilsCommon.getHttpClientForGitHub(
    accessToken = "your_github_token",
    isDevelopmentMode = true  // Enables request/response logging
)
```

### API Response Handling

```kotlin
import common.utils.library.utils.ApiUtilsCommon

// Handle API responses with success/failure callbacks
ApiUtilsCommon.apiResponseHandler(
    apiResponse = Result.success(data),
    apiFailureActions = { println("API call failed") },
    apiSuccessActions = { response -> println("Received: $response") }
)
```

### MySQL DateTime Conversion

```kotlin
import common.utils.library.utils.MysqlUtils

// Convert normal date format to MySQL format
val mysqlResult = MysqlUtils.normalDateTimeTextToMySqlDateTimeText(
    normalDateTimeText = "26/11/2024 15:30:45"
)

if (mysqlResult.isOK) {
    println(mysqlResult.data) // Output: 2024-11-26 15:30:45
}
```

---

## 📖 API Reference

### DateTimeUtils

| Method | Description |
|--------|-------------|
| `getCurrentNormalDateTimeInText()` | Returns current date/time in `dd/MM/yyyy HH:mm:ss` format |
| `addDaysToNormalDateTimeInText(dateTimeInText, days)` | Adds specified days to a date string |
| `subtractDaysFromNormalDateTimeInText(dateTimeInText, days)` | Subtracts specified days from a date string |
| `addHoursToNormalDateTimeInText(dateTimeInText, hours)` | Adds hours to a date/time string |
| `subtractHoursFromNormalDateTimeInText(dateTimeInText, hours)` | Subtracts hours from a date/time string |
| `addMinutesToNormalDateTimeInText(dateTimeInText, minutes)` | Adds minutes to a date/time string |
| `resetTimeOnNormalDateTimeInTextToX(dateTimeInText)` | Resets time to 09:00:00 |
| `normalDateTimeInTextToDateTime(normalDateTimeInText)` | Parses string to `LocalDateTime` |

### MysqlUtils

| Method | Description |
|--------|-------------|
| `normalDateTimeTextToMySqlDateTimeText(normalDateTimeText)` | Converts `dd/MM/yyyy HH:mm:ss` to `yyyy-MM-dd HH:mm:ss` |
| `mySqlDateTimeTextToNormalDateTimeText(mySqlDateTimeText)` | Converts MySQL format to normal format |
| `mySqlDateTimeTextToDateTime(mySqlDateTimeText)` | Parses MySQL date string to `LocalDateTime` |
| `normalDateTextToMySqlDateText(normalDateText)` | Converts date-only format |

### IsOkModel (Result Pattern)

| Class | Description |
|-------|-------------|
| `IsOkModel<T>` | Base result class with `isOK`, `data`, and `error` properties |
| `SuccessBasedOnIsOkModel<T>` | Success result with data |
| `SuccessWithoutDataBasedOnIsOkModel<T>` | Success result without data |
| `FailureBasedOnIsOkModel<T>` | Failure result with error message |
| `FailureWithoutExplanationBasedOnIsOkModel<T>` | Failure result without error message |

### EnvironmentFileOperations

| Method | Description |
|--------|-------------|
| `getEnvironmentVariableValueForTextWithDefaultValue(dotEnv, name, default)` | Gets env variable with fallback |
| `isEnvironmentVariablesAreAvailable(envVars)` | Checks if all required env variables exist |

---

## 🔧 Development Setup

### Prerequisites

1. **Install JDK 21**
   ```bash
   # Using SDKMAN (recommended)
   sdk install java 21.0.2-open
   sdk use java 21.0.2-open
   
   # Or using mise (as configured in mise.toml)
   mise install
   ```

2. **Clone the Repository**
   ```bash
   git clone https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Gradle.git
   cd Common-Utils-Library-Kotlin-Gradle
   ```

3. **Verify Installation**
   ```bash
   java -version  # Should show Java 21+
   ./gradlew --version
   ```

### IDE Setup

#### IntelliJ IDEA (Recommended)
1. Open IntelliJ IDEA
2. Select `File → Open` and choose the project directory
3. Wait for Gradle sync to complete
4. Configure Project SDK to JDK 21

#### VS Code
Install the following extensions:
- `mathiasfrohlich.kotlin` - Kotlin Language Support
- `mhutchie.git-graph` - Git Graph Visualization
- `codezombiech.gitignore` - .gitignore Support

### Gitpod Development

This project supports [Gitpod](https://gitpod.io/) for cloud-based development:

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Gradle)

The Gitpod configuration automatically:
- Sets up the development environment
- Prebuilds the project
- Configures VS Code extensions

---

## 🔨 Building & Testing

### Build Commands

```bash
# Clean build
./gradlew clean build

# Build without tests
./gradlew assemble

# Run only compilation
./gradlew compileKotlin

# Check for issues
./gradlew check
```

### Testing

```bash
# Run all tests
./gradlew test

# Run tests with coverage report
./gradlew test jacocoTestReport

# View coverage report
open common-lib/build/reports/jacoco/test/html/index.html
```

### Code Quality

The project uses JaCoCo for code coverage. Reports are generated automatically after test execution and can be found at:
- **HTML Report**: `common-lib/build/reports/jacoco/test/html/`
- **XML Report**: `common-lib/build/reports/jacoco/test/jacocoTestReport.xml`

---

## 🔄 CI/CD Pipelines

This project includes multiple CI/CD configurations:

### GitHub Actions

**Workflow**: `.github/workflows/gradle.yml`

Triggers on:
- Push to `master` branch
- Pull requests to `master` branch

```yaml
- Uses Oracle JDK 21
- Runs: ./gradlew build
```

### Travis CI

**Configuration**: `.travis.yml`

- Language: Java
- Coverage reporting via Codecov

### Azure Pipelines (Windows)

**Configuration**: `azure-pipelines-windows.yml`

- VM Image: `windows-latest`
- Includes Gradle build cache
- Stops Gradle daemon after build

### Jenkins

**Configuration**: `Jenkinsfile`

- Simple pipeline with build stage
- Uses `gradlew.bat build` for Windows

---

## 🤝 Contributing

We welcome contributions! Please follow these guidelines:

### Getting Started

1. **Fork the Repository**
   ```bash
   # Click 'Fork' on GitHub, then clone your fork
   git clone https://github.com/YOUR_USERNAME/Common-Utils-Library-Kotlin-Gradle.git
   ```

2. **Create a Feature Branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make Your Changes**
   - Follow the existing code style
   - Add/update tests as needed
   - Update documentation if applicable

4. **Run Tests**
   ```bash
   ./gradlew test
   ```

5. **Commit Your Changes**
   ```bash
   git commit -m "feat: add your feature description"
   ```

6. **Push and Create PR**
   ```bash
   git push origin feature/your-feature-name
   ```
   Then create a Pull Request on GitHub.

### Code Style Guidelines

- Use explicit parameter names for better readability
- Follow Kotlin coding conventions
- Add `@JvmStatic` annotation for methods that should be accessible from Java
- Use meaningful variable and function names
- Document public APIs with KDoc comments

### Commit Message Convention

Follow [Conventional Commits](https://www.conventionalcommits.org/):

- `feat:` New feature
- `fix:` Bug fix
- `docs:` Documentation changes
- `style:` Code style changes (formatting, etc.)
- `refactor:` Code refactoring
- `test:` Adding or updating tests
- `chore:` Maintenance tasks

### Dependency Updates

This project uses [Renovate](https://github.com/renovatebot/renovate) for automated dependency updates. Configuration can be found in `renovate.json`.

---

## 📄 License

This project is open source. Please check the repository for license details.

---

## 🙏 Acknowledgments

- [JetBrains](https://www.jetbrains.com/) for Kotlin and the amazing IDE
- [Ktor](https://ktor.io/) team for the HTTP client framework
- [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization) for JSON serialization
- All contributors who help improve this library

---

<p align="center">
  <strong>Built with ❤️ in Kotlin</strong>
</p>

<p align="center">
  <a href="https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Gradle/issues">Report Bug</a>
  ·
  <a href="https://github.com/Baneeishaque/Common-Utils-Library-Kotlin-Gradle/issues">Request Feature</a>
</p>
