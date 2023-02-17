package application;

import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();

		Scanner sc = new Scanner(System.in);

		while(true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());

				System.out.println();
				System.out.println("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean [][] possibleMovies = chessMatch.possibleMovies(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(),possibleMovies);

				System.out.println();
				System.out.println("Target");
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMatch.performChessMovie(source, target);
			}
			catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}

