package codingon_kdt.spring_boot_default._02_dto_vo.vo;

import java.util.Objects;

//final class는 상속이 불가능함. => 불변성 보장.
public final class Point {
    // 초기화 되면 변경이 불가능하게 함.
    private final int x;
    private final int y;

    //constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //getter(setter가 없으므로 불변성 유지 가능)
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //비즈니스 로직 : 두 점 사이의 거리 계산하기
    public double distanceTo(Point other){
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) { // 객체의 동등성을 정의
        //1. 현재객체(this)와 비교대상 객체(o)가 같은 참조를 가리킨다면 true!
        if (this == o) return true;

        //2. 현재객체(this)와 비교대상 객체(o)가 null이거나 현재 객체와 다른클래스의 인스턴스라면(getClass()) false!
        if (o == null || getClass() != o.getClass()) return false;

        //3. 비교 대상 객체를 Point 타입으로 형변환.
        Point point = (Point) o;
        // 두 객체의 x, y값이 같은 지 확이, 결과를 boolean으로 반환.
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        //Object 클래스의 hash 메서드를 사용하여 x, y값을 기반으로 해시 코드를 생성.
        //=> 내부적으로 해시 알고리즘을 사용해서 객체의 필드값을 결합한 해시 코드 생성.
        return Objects.hash(x, y);
    }
}
