package Minesweeper;

import java.util.Arrays;
import java.util.Random;

public class Minesweeper {

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
        char[][] border = minesweeper.createArray();
        char[][] borderSolution = minesweeper.replacePoints(border);
        minesweeper.printBorder(borderSolution);
    }


    private void printBorder(char[][] borderSolution) {
        for (char[] row : borderSolution){
            System.out.println(Arrays.toString(row));
        }
    }


    public char[][] createArray(){
        Random random = new Random();
        int size = 8;
        int mines = 10;
        char[][] arr = new char[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                arr[i][j] = '.';
            }
        }
        addMines(random, size, mines, arr);
        return arr;
    }

    private void addMines(Random random, int size, int mines, char[][] arr) {
        int minesCount = 0;
        while(minesCount < mines) {
            int randomI = random.nextInt(size);
            int randomJ = random.nextInt(size);
            if(arr[randomI][randomJ] != '*'){
                arr[randomI][randomJ] = '*';
                minesCount++;
            }
        }
    }

    public char[][] replacePoints(char[][] border) {

        for(int i = 0; i < border.length; i++){
            for(int j = 0; j < border.length; j++){
                char element = border[i][j];
                int count = 0;
                if (element != '*'){
                    for(int k = -1; k < 2; k++){
                        for(int l = -1; l < 2; l++){
                            int x = i + k;
                            int y = j + l;
                            if (x >= 0 && x < border.length && y >= 0 && y < border.length){
                                char position = border[x][y];
                                if (position == '*'){
                                    count++;
                                }
                            }

                        }
                    }
                    border[i][j] = Character.forDigit(count, 10);
                }

            }
        }
        return border;
    }



}
