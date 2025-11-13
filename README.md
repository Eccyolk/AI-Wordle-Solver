# 🧠 AI-Wordle-Solver
*A logic-driven Wordle solver in Java - play, watch, or compete with the AI.*

---

## 🧩 Overview
A Java project that plays and solves the popular *New York Times* game **Wordle** through logical elimination and smart filtering.<br>
Includes **User Mode**, **AI Mode**, and **User vs AI Mode** for a fun interactive experience.

---

## 🚀 Features
- Loads official Wordle lists from external `.txt` files  
- Colour-coded feedback (green, yellow, grey)  
- Filters out impossible words after each guess
- Modular and easy-to-read Java code
> *Note: The “AI” uses logic-based elimination, not machine learning - the name just sounds cooler!*

---

## 🕹️ How to Run
```bash
git clone https://github.com/Eccyolk/AI-Wordle-Solver.git
cd AI-Wordle-Solver
javac main/java/solver/*.java
java main.java.solver.MainMenu
```
Make sure `answerwords.txt` and `validwords.txt` are located in the `resources/` folder.

---

## 💡 Example Output (truncated)
```
===============================
  WELCOME TO AI WORDLE SOLVER
===============================

1. Play a classic game of Wordle
2. Let AI guess
3. Play against AI
4. Quit

Attempt 1: AI guesses SLATE
⬜⬜🟨⬜🟨

Attempt 2: AI guesses AHEAD
🟩⬜🟩⬜🟩

Attempt 3: AI guesses AMEND
🟩🟩🟩🟩🟩

AI guessed the word in 3 attempts!
```

---

## 🧰 Built With
- **Language:** Java (JDK 17+)
- **Libraries:** Standard Java libraries (`java.util`, `java.io`)
- **Interface:** Terminal-based with ANSI colour codes

---

## 🏷️ Author
**Eccyolk**<br>
📅 *Created:* November 2025<br>
🔗 [GitHub Profile](https://github.com/Eccyolk)

---

## 📄 License
This project is licensed under the **MIT License** - see the [LICENSE](https://github.com/Eccyolk/AI-Wordle-Solver/blob/main/LICENSE) file for details.
