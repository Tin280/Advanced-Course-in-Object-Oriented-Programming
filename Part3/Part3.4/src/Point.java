class Number {
    int value;

    Number(int value) {
        this.value = value;
    }
}

// Seuraavat mallintavat kokonaislukumuotoisen
// 2d-koordinaatiston pisteen (x, y).

public class Point {
    final int[] values = new int[2];

    Point(int x, int y) {
        values[0] = x;
        values[1] = y;
    }
}

record RecordPoint(int x, int y) {
}

record RecordPointNumber(Number x, Number y) {
    RecordPointNumber(int x, int y) {
        this(new Number(x), new Number(y));
    }
}
