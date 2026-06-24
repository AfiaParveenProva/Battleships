# ⚓ Battleships – Java 

## 📖 Project Overview

This repository contains a library of Java static methods that simulate the core logic of the classic **Battleships** strategy game. Rather than a full playable game, the project implements a suite of reusable functions that could serve as the backbone of a complete Battleships application.

The methods operate on a **10×10 character grid** representing a player's ship board, where each cell can contain:

| Character | Meaning |
|-----------|---------|
| `.` | Open water |
| `S` | Part of an undamaged ship |
| `*` | Part of a damaged/sunk ship |

---

## 🚢 Ship Types

| ID | Class | Size (squares) |
|----|-------|---------------|
| 1 | Carrier | 5 |
| 2 | Battleship | 4 |
| 3 | Cruiser | 3 |
| 4 | Destroyer | 2 |

Ships are always placed **horizontally** and are never adjacent to one another. A ship consisting entirely of `S` is undamaged; a mix of `S` and `*` is damaged; all `*` means it has sunk.

---

## 🗂️ Board Representation

The board is a `char[10][10]` array in Java (0-indexed), but is addressed externally using:

- **Rows:** 1–10
- **Columns:** A–J (uppercase only)

So position `"1A"` maps to array index `[0][0]`, position `"10J"` maps to `[9][9]`, and so on.

### Example Board

```
    A  B  C  D  E  F  G  H  I  J
1   .  .  .  .  .  .  .  .  .  .
2   .  .  S  S  .  .  .  .  .  .
3   .  .  *  *  .  .  .  .  .  .
4   .  .  .  .  .  .  .  .  .  .
5   .  .  .  .  .  .  .  .  .  .
6   .  .  .  .  .  .  .  .  .  .
7   .  .  .  .  .  .  .  .  .  .
8   .  .  .  .  .  .  .  .  .  .
9   .  .  .  .  S  S  S  .  S  *
10  .  .  .  .  .  .  .  .  .  .
```

In this example:
- Row 2 (C–D): Undamaged Destroyer (`SS`)
- Row 3 (C–D): Sunk Destroyer (`**`)
- Row 9 (E–G): Undamaged Cruiser (`SSS`)
- Row 9 (I–J): Damaged Destroyer (one hit: `S*`)

---

## ⚙️ Methods Implemented

### `1.1 – isValidBoardSquare(char c)`
**Returns:** `boolean`

Checks whether a single character is a valid board square (`.`, `S`, or `*`).

```java
public static boolean isValidBoardSquare(char c)
```

---

### `1.2 – isValidBoard(char[][] board)`
**Returns:** `int`

Validates the entire board. Return codes (specified during examination):
- Board is `null`
- Board is the wrong size (not 10×10)
- Board contains at least one invalid character
- Board is valid

```java
public static int isValidBoard(char[][] board)
```

---

### `1.3 – numberSunk(char[][] board)`
**Returns:** `int`

Given a valid board, returns the total number of **sunk ships** (those made up entirely of `*` characters). Returns a defined value if no ships are present.

```java
public static int numberSunk(char[][] board)
```

---

### `1.4 – hit(int row, char col, char[][] board)`
**Returns:** `int`

Processes an attack at a given board coordinate. Return codes:
- Invalid row number
- Invalid column character
- Hit (`S` at location)
- Miss (`.` at location)
- Repeated hit (`*` at location)

```java
public static int hit(int row, char col, char[][] board)
```

---

### `1.5 – countShips(char[][] board, String shipType, String damageType)`
**Returns:** `int`

Counts the ships on the board matching both the **ship type** and **damage status** provided.

- `shipType`: Can be an ID (`"1"`, `"2"`, etc.) or class name (`"Carrier"`, `"Battleship"`, etc.)
- `damageType`: One of `"undamaged"`, `"damaged"`, `"sunk"`, or `"all"`

Return codes also handle:
- Invalid ship type
- Invalid damage type
- No ships on the board

```java
public static int countShips(char[][] board, String shipType, String damageType)
```

---

### ⭐ Bonus – `damageReport(char[][] board)`
**Returns:** `double[]` (or similar array type)

Generates a damage report for all ship types on the board. Each index in the returned array corresponds to a ship ID (1–4), holding the **average percentage damage** across all ships of that class. Returns an error value for ship types not present on the board. Also handles invalid board input.

```java
public static double[] damageReport(char[][] board)
```

---

## 🧠 Design Notes

- All methods are `public static` — no class instantiation required.
- Methods are designed to be **composable**: later methods call earlier ones (e.g., `countShips` may use `isValidBoard` and `hit`).
- **No `System.out.println`** calls are included — all results are returned as values.
- **No import statements** are used beyond what is provided by the CodeRunner environment.
- All methods handle invalid/null input gracefully with defined error return values.

---

## 🏗️ Repository Structure

```
CS1702-Battleships/
├── README.md
├── src/
│   └── BattleshipsLib.java        # All methods in one file
└── test/
    └── BattleshipsLibTest.java    # Manual test cases
```

---

## 🧪 Testing

Since CodeRunner tests submissions automatically with a wide range of inputs (including null boards, wrong sizes, invalid characters, and edge cases), the test file covers:

- Null board input
- Boards smaller or larger than 10×10
- Boards with invalid characters
- Empty boards (valid but no ships)
- Fully undamaged, partially damaged, and fully sunk ships
- Invalid row/column values for `hit()`
- All ship type and damage type combinations for `countShips()`

---

## 📋 Assessment Details

| Detail | Value |
|--------|-------|
| Module | CS1702 Introductory Programming |
| Task | Task #2 |
| Contribution | 60% of module grade |
| Marked out of | 15 marks (bonus up to 20, capped at 15) |
| Assessment type | CodeRunner (automated testing) |
| Examination period | 29 April – 17 May 2024 |

### Grading Scale

| Mark (%) | Grade |
|----------|-------|
| 70%+ | A (A− to A*) |
| 60–69% | B |
| 50–59% | C |
| 40–49% | D |
| 30–39% | E |
| < 30% | F |

---

## 📚 References

- [Battleships – Wikipedia](https://en.wikipedia.org/wiki/Battleship_(game))
- [How to Play Battleships (YouTube)](https://www.youtube.com/watch?v=8Y_CJFgqbA)
- Brunel University London – CS1702 Module Documentation

---

## ⚠️ Academic Integrity

This repository is shared for **portfolio and learning reference purposes only**. Submitting any part of this code as your own original work for a live assessment constitutes **academic misconduct** under Brunel University London Senate Regulation 6 and may result in serious penalties including expulsion.

---

*Developed as part of the BSc Computer Science programme at Brunel University London.*
