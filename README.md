# PDFStacker CLI

**PDFStacker CLI** is a simple command-line utility for merging/binding a list of PDF files together.

![Screenshot1](/screenshots/screenshot1.png)

---

## Features & Commands
```
add <filePath>           Add a PDF to the merge list
list                     List PDFs currently in the merge list
remove <index>           Remove a PDF by index
move <from> <to>         Move a PDF to a new position
merge <output.pdf>       Merge all PDFs into a single file
startover                Clear the merge list
scanf                    Scan a folder for PDFs
scanfd                   Scan a folder and subfolders for PDFs
help                     Show available commands
exit                     Exit the application
```
---

## Running the Application

### Option 1: Windows Executable (No Setup Required)

Download the `.exe` from the Releases page and double-click to run the application.

No additional installation is required.

### Option 2: Run from Source

1. Ensure Java 17 or newer is installed.

Check your Java version:
```bash
java -version
```

Clone the repository:
```bash
git clone https://github.com/yourusername/PDFStacker.git
cd PDFStacker
```

Compile the project:
```bash
javac -d out src/*.java
```

Run the application:
```bash
java -cp out App
```

---

## Requirements

- **Java 17+** (JDK recommended)
- [Apache PDFBox](https://pdfbox.apache.org/) (included via Maven or Gradle)
- Terminal / console that supports ANSI colors (optional for colored output)




