package SolvedFirstTime;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/design-excel-sum-formula/
 */
public class Excel {
    private int rlim;
    private char clim;
    private Cell[][] cells;

    public static void main(String...args) {
        Excel e = new Excel(5, 'E');
        // construct a 3*3 2D array with all zero.
        //   A B C
        // 1 0 0 0
        // 2 0 0 0
        // 3 0 0 0
        e.print();

        e.set(1, 'A', 5);
        e.set(1, 'B', 3);
        e.set(1, 'C', 2);
        e.print();
        e.sum(1,'C',new String[]{"A1","A1:B1"});

        e.print();

    }

    private static class Cell {
        int value;
        HashMap<Cell, Integer> linkto;
        HashSet<Cell> linkedFrom;
        Cell(int value) {
            this.value = value;
            this.linkedFrom = new HashSet<>();
            this.linkto = new HashMap<>();
        }

        void incrementValue(int v) {
            this.value += v;
            for (Cell c : linkto.keySet()) {
                c.incrementValue(v * linkto.get(c));
            }
        }

        void addLinkTo(Cell cell) {
            if (this.linkto.containsKey(cell)) {
                this.linkto.put(cell, this.linkto.get(cell) + 1);
            } else {
                this.linkto.put(cell, 1);
            }
        }

        void addLinkFrom(Cell cell) {
            this.linkedFrom.add(cell);
        }

        void removeLinkTo(Cell cell) {
            this.linkto.remove(cell);
        }

        void clearLinkedFrom() {
            for (Cell c : this.linkedFrom) {
                c.removeLinkTo(this);
            }
            this.linkedFrom.clear();
        }

    }
    public Excel(int H, char W) {
        this.rlim = H;
        this.clim = W;
        this.cells = new Cell[H][chartoInt(W)];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < chartoInt(W); j++) {
                this.cells[i][j] = new Cell(0);
            }
        }
    }

    public void set(int r, char c, int v) {
        if (!checkrc(r, c)) {
            return;
        }
        Cell cell = this.cells[r - 1][chartoInt(c) - 1];
        // set the values
        cell.incrementValue(v - cell.value);
        cell.clearLinkedFrom();
    }

    public int get(int r, char c) {
        if (checkrc(r, c) && this.cells[r - 1][chartoInt(c) - 1] != null) {
            return this.cells[r - 1][chartoInt(c) - 1].value;
        } else {
            return 0;
        }
    }

    public int sum(int r, char c, String[] strs) {
        Cell cell = this.cells[r - 1][chartoInt(c) - 1];
        cell.clearLinkedFrom();
        int sum = 0;
        for (String s : strs) {
            String[] sp = s.split(":");
            if (sp.length == 2) {
                int c1 = chartoInt(sp[0].charAt(0)) - 1;
                int r1 = Integer.parseInt(sp[0].substring(1)) - 1;
                int c2 = chartoInt(sp[1].charAt(0)) - 1;
                int r2 = Integer.parseInt(sp[1].substring(1)) - 1;
                if (!checkrc(r1, intToChar(c1)) || !checkrc(r2, intToChar(c2))) {
                    System.out.println("Out of Range: " + s);
                    continue;
                }
                int sum1 = 0;
                for (int i = r1; i <= r2; i++) {
                    for (int j = c1; j <= c2; j++) {
                        Cell cl = this.cells[i][j];
                        sum += cl.value;
                        cl.addLinkTo(cell);
                        cell.addLinkFrom(cl);
                    }
                }
                sum += sum1;
            } else if (sp.length == 1) {
                int rt = Integer.parseInt(sp[0].substring(1));
                char ct = sp[0].charAt(0);
                if (checkrc(rt, ct)) {
                    sum += this.get(rt, ct);
                    Cell cl = this.cells[Integer.parseInt(sp[0].substring(1)) - 1][chartoInt(sp[0].charAt(0)) - 1];
                    cl.addLinkTo(cell);
                    cell.addLinkFrom(cl);
                }
            }
        }
        int diff = sum - cell.value;
        cell.incrementValue(diff);
        return sum;
    }
    // 1 based
    private int chartoInt(char c) {
        return c - 64;
    }
    // 1 based
    private char intToChar(int i) {
        return (char) (i + 64);
    }
    // 1 based
    private boolean checkrc(int r, char c) {
        return !(r > this.rlim && c > this.clim);
    }

    public void print() {
        for (int i = 0; i < rlim; i++) {
            for (int j = 0; j < chartoInt(this.clim); j++) {
                System.out.print(this.get(i + 1, intToChar(j + 1)) + " ");
                System.out.flush();
            }
            System.out.println();
        }
    }
}
