package ro.jademy.contact;

import java.util.List;
import java.util.Objects;

public class PhoneNumber {
    private List<String> numbers;
    private String suffix;

    public PhoneNumber(List<String> numbers, String suffix) {
        this.numbers = numbers;
        this.suffix = suffix;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber phone = (PhoneNumber) o;
        return Objects.equals(numbers, phone.numbers) &&
                Objects.equals(suffix, phone.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, suffix);
    }
}
