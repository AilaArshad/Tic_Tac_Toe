# GUI-Based Tic Tac Toe – Java Swing

This project is a **graphical Tic Tac Toe game** built using **Java Swing**, providing a clean and interactive interface for two players.
It combines intuitive GUI design with well-structured game logic, offering a fun way to experience the classic game on desktop.

---

## 📝 Overview

The application allows two players to compete in a **3x3 grid** Tic Tac Toe match.
Players alternate turns by clicking on the desired square, with the interface visually updating to display their move.
The game automatically detects win conditions and draws, displaying appropriate messages to players.

---

## 🎯 Key Features

* **Interactive GUI** using Java Swing for an engaging experience.
* **3x3 Grid Layout** implemented with **JButtons** for easy move selection.
* **Real-time Turn Tracking** using labels to indicate the current player.
* **Win Detection Algorithm** that checks rows, columns, and diagonals after every move.
* **Draw Condition Check** when all cells are filled with no winner.
* **Responsive Design** with clearly visible buttons and status indicators.

---

## 🛠 Implementation Details

* **Main Window**: Created using `JFrame` as the primary container.
* **Game Board**:

  * 3x3 grid of `JButton` components to represent each cell.
  * Styled for clear distinction between empty cells and marked cells.
* **Game State Tracking**:

  * 2D array (`char[][] board`) to store current moves (`'X'`, `'O'`, or empty).
  * Boolean flag to track the active player.
* **Logic Flow**:

  1. Player clicks a button → Cell is marked with player’s symbol.
  2. Board updates → Win condition is checked.
  3. If win detected → Display winner message and disable further moves.
  4. If no win and board is full → Declare draw.
  5. If neither → Switch turn and continue.
* **Win Condition Checking**:

  * Horizontal check for all rows.
  * Vertical check for all columns.
  * Diagonal checks (both main and anti-diagonal).
* **UI Feedback**:

  * `JLabel` displays current player’s turn or game results.

---

## 💡 Possible Enhancements

* **Single-player mode** with basic AI (Minimax algorithm).
* **Score tracking** for multiple rounds.
* **Custom board sizes** (e.g., 4x4 or 5x5).
* **Improved styling** with custom colors, fonts, and icons.

