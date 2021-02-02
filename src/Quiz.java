import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int totalCorrectAnswers = 0;

		String[] q1answers = { "Melbourne", "Anchorage", "Juneau" };
		Question q1 = new Question("What is the capital of Alaska?", q1answers, "Juneau");

		String[] q2answers = { "yes", "no" };
		Question q2 = new Question("Can you store the value \"cat\" in a variable of type int?", q2answers, "no");

		String[] q3answers = { "5", "11", "15/3" };
		Question q3 = new Question("What is the result of 9+6/3?", q3answers, "11");

		Question[] alLQuestions = { q1, q2, q3 };

		int questionIndex = 1;
		for (Question question : alLQuestions) {
			question.print_question(questionIndex);
			boolean isAnswerCorrect = handle_question_answer(question, keyboard);
			if (isAnswerCorrect) {
				totalCorrectAnswers++;
			}
			questionIndex++;
		}

		System.out.printf("Overall, you got %d out of %d correct.", totalCorrectAnswers, alLQuestions.length);
	}

	static boolean handle_question_answer(Question currentQuestion, Scanner keyboard) {
		boolean correctAnswer = false;
		while (true) {
			try {
				System.out.print("What is your answer? > ");
				int currentAnswerIndex = keyboard.nextInt();
				if (currentQuestion.check_answer(currentAnswerIndex - 1)) {
					System.out.println("That is right!\n");
					correctAnswer = true;
				} else {
					System.out.println("Sorry, that is wrong.\n");
				}
				return correctAnswer;
			} catch (InputMismatchException e) {
				keyboard.next();
				System.out.println("Only use numbers to answer.");
			}
		}

	}
}

class Question {
	String questionText;
	String[] answersText;
	String correctAnswer;

	Question(String questionText, String[] answersText, String correctAnswer) {
		this.questionText = questionText;
		this.answersText = answersText;
		this.correctAnswer = correctAnswer;
	}

	void print_question(int questionIndex) {
		System.out.printf("Q%d) %s%n", questionIndex, this.questionText);
		int answerIndex = 1;
		for (String answer : this.answersText) {
			System.out.printf("\t%d) %s%n", answerIndex, answer);
			answerIndex++;
		}
	}

	boolean check_answer(int answerIndex) {
		return this.answersText[answerIndex].equals(this.correctAnswer);
	}
}