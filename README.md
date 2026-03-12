# PDFStacker CLI

**PDFStacker CLI** is a simple command-line utility for merging/binding a list of PDF files together.

![Screenshot1](/screenshots/screenshot1.png)
---

## Features

- Add PDFs to a merge stack (`add <filePath>`)
- List PDFs in the merge stack (`list`)
- Remove a PDF by its index from the merge stack (`remove <indexNumber>`)
- Move a PDF up or down in the merge stack (`move <currentIndex> -> <newIndex>`)
- Merge all PDFs from the merge stack into a single file (`merge <output.pdf>`)
- Start over and reset the stack (`startOver`)
- Scan a folder for PDFs ('scanf')
- Scan a folder and its subfolders for PDFS ('scanfd')
- Help command to show all available commands (`help`)
- Exit the application (`exit`)

---

## Requirements

- **Java 17+** (JDK recommended)
- [Apache PDFBox](https://pdfbox.apache.org/) (included via Maven or Gradle)
- Terminal / console that supports ANSI colors (optional for colored output)

---


