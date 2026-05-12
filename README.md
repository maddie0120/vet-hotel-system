# Veterinary-Hotel-System 🏨

The goal of this project is to develop a management application for a veterinary hotel. This system manages animals 🐕, species 🧬, habitats with trees 🌳, employees 👩‍⚕️, vaccinations 💉, and satisfaction levels 📊 through a menu-driven interface.

## 📋 Project Overview

This project implements a comprehensive management system for a veterinary hotel facility. The system allows for efficient organization and tracking of:

- **Animals**: Registration, management, habitat transfers, and satisfaction calculation
- **Species**: Registration and association with animals, veterinarians, and vaccines
- **Habitats**: Environmental spaces where animals are housed, including trees and species influence
- **Employees**: Staff members, including veterinarians and caretakers, with assigned responsibilities
- **Vaccinations**: Vaccine registration, administration records, and health impact tracking

## 🖥️ User Interaction

The application provides a menu-driven interface that allows users to manage the different entities of the veterinary hotel.

```text
Main Menu
├── Create new session
├── Open existing session
├── Save current session
├── Advance season
├── View global satisfaction
├── Animal Management
│   ├── Show all animals
│   ├── Register an animal
│   ├── Transfer an animal
│   └── Calculate animal satisfaction
├── Employee Management
│   ├── Show all employees
│   ├── Register an employee
│   ├── Assign a responsibility
│   ├── Remove a responsibility
│   └── Calculate employee satisfaction
├── Habitat Management
│   ├── Show all habitats
│   ├── Register a habitat
│   ├── Change habitat area
│   ├── Change species influence
│   ├── Plant a tree
│   └── Show habitat trees
├── Vaccine Management
│   ├── Show all vaccines
│   ├── Register a vaccine
│   ├── Vaccinate an animal
│   └── Show vaccination history
└── Consultations
    ├── Search animals by habitat
    ├── Search vaccines by animal
    ├── Search medical acts by veterinarian
    └── Search wrong vaccinations
```

## 🗂️ Project Structure

```text
.
├── proj/
│   ├── hva-app/        # User interaction layer and menu commands
│   ├── hva-core/       # Domain classes and business logic
│   ├── po-uilib/       # Provided support library for the UI
│   └── Makefile        # Build automation
├── uml/                # UML diagrams from the design phase
└── README.md
```

### Module Description

- **`hva-core`** — contains the core domain model, including animals, species, habitats, trees, employees, vaccines, satisfaction calculations, persistence, and import logic.
- **`hva-app`** — contains the application interface, menus, commands, prompts, and exception handling related to user interaction.
- **`po-uilib`** — provides the required support classes for building the textual menu interface.
- **`uml`** — stores the UML diagrams used to represent the project design and relationships between classes.

## 🔧 How to Run

### ✅ 1. Check Java Installation

Make sure you have **Java** installed on your system.

This project was developed using **Java 22**, so it is recommended to use Java 22 or a compatible version.

To verify your Java installation, open a terminal and run:

```bash
java --version
```

You should also check if the Java compiler is available:

```bash
javac --version
```

If Java is installed correctly, both commands should display the installed version.

### ✅ 2. Compile the UI Support Library

Before compiling the full project, the `po-uilib` support library must be compiled first.

From the `proj/` directory, run:

```bash
cd po-uilib
make all
cd ..
```

This generates the `po-uilib.jar` file required by the application layer.  
The `hva-app` module depends on this library for the menu system, commands, forms, prompts, and display utilities.

### ✅ 3. Compile the Project

Now, from the `proj/` directory, compile the remaining project modules:

```bash
make all
```

This compiles `hva-core` and `hva-app`, generating the required `.jar` files.

### ✅ 4. Run the Application

From the `proj/` directory, run:

```bash
java -cp po-uilib/po-uilib.jar:hva-core/hva-core.jar:hva-app/hva-app.jar hva.app.App
```

The application will start with an empty state and display the main menu.

You should see:

```text
Menu Principal
1 - Criar ficheiro
2 - Abrir ficheiro
3 - Guardar ficheiro
4 - Avançar estação do ano
5 - Ver satisfação global
6 - Gestão de animais
7 - Gestão de funcionários
8 - Gestão de habitats
9 - Gestão de vacinas
10 - Consultas
0 - Sair
Escolha uma opção:
```

### ✅ 5. Run with an Import File

You can also start the application with predefined data using the `import` property:

```bash
java -Dimport=test.import -cp po-uilib/po-uilib.jar:hva-core/hva-core.jar:hva-app/hva-app.jar hva.app.App
```

The import file initializes the system with predefined species, animals, habitats, trees, employees, and vaccines.

## 👩‍💻 Authors

<p align="center">
  <a href="https://github.com/maddie0120">
    <img src="https://img.shields.io/badge/Madalena%20Yang-@maddie0120-blue?style=for-the-badge&logo=github" alt="Madalena Yang GitHub"/>
  </a>
  &nbsp;&nbsp;&nbsp;
  <a href="https://github.com/leonor-a-a-ist">
    <img src="https://img.shields.io/badge/Leonor%20Azevedo-@leonor--a--a--ist-blue?style=for-the-badge&logo=github" alt="Leonor Azevedo GitHub"/>
  </a>
</p>

## 📄 Project Description

You can find the full project description [here](https://github.com/maddie0120/vet-hotel-system/blob/main/PO-Enunciado%20do%20Projeto.pdf).
