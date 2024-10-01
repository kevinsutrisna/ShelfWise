# ShelfWise

ShelfWise is a simple command-line interface (CLI) application that allows users to manage a personal book collection. With features for adding book data, generating unique hash codes for each book, and handling borrowing/returning transactions, ShelfWise helps to organize your library efficiently.

---

## Table of Contents

- [Features](#features)
- [Installation](#installation)

---

## Features

- **Add new books**: Input interesting book details like title, author, and ISBN.
- **Generate unique book hash codes**: Each book is assigned a unique hash code for easy identification.
- **Track borrow/return transactions**: Monitor when a book is borrowed or returned.
- **CLI-based**: Interact with the system using simple command-line operations.

---

## Installation

To run *ShelfWise* on your local machine, follow these steps:

### Prerequisites

- Java 8 or higher installed. 
- Git installed.

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/shelfwise.git
2. Navigate to the project directory:
   ```bash
   cd shelfwise
3. Compile the project:
   ```bash
   javac -d bin src/uas/*.java
4. Run the application:
   ```bash
   java -cp bin uas.Main

To run *ShelfWise* on  github codespaces, follow these steps:
1. Go to codespaces
   [Codespaces](https://jubilant-barnacle-r4p7xj7wpvvgh54j6.github.dev/)
2. Run the application:
   ```bash
   java -cp bin uas.Main
