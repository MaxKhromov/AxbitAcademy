package hw6;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");

        System.out.println("Найти методы определяющие была ли дата до текущего времени или после (строгое и не строгое равенство)");
        System.out.println("---");

        LocalDate date = LocalDate.now();
        LocalDate inputDate = date.minusDays(5);

        if (date.isBefore(inputDate) || date.isEqual(inputDate)) {
            System.out.println("Дата " + inputDate + " больше или равна текущей на " + date.until(inputDate).getDays() + " дней");
        } else if (date.isAfter(inputDate)) {
            System.out.println("Дата " + inputDate + " меньше текущей на " + Math.abs(date.until(inputDate).getDays()) + " дней");
        }
        System.out.println("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");

        System.out.println("Решить задачу с гостиницей и постояльцами, заменив числа на даты");
        System.out.println("---");

        List<List<LocalDate>> inputDates = new ArrayList<>() {
            {
                add(new ArrayList<>() {
                    {
                        add(LocalDate.now());
                        add(LocalDate.now().plusDays(1));
                    }
                });
                add(new ArrayList<>() {
                    {
                        add(LocalDate.now());
                        add(LocalDate.now().plusDays(2));
                    }
                });
                add(new ArrayList<>() {
                    {
                        add(LocalDate.now().plusDays(1));
                        add(LocalDate.now().plusDays(3));
                    }
                });
                add(new ArrayList<>() {
                    {
                        add(LocalDate.now().plusDays(1));
                        add(LocalDate.now().plusDays(2));
                    }
                });
            }
        };

        //Создаем хешмап и подсчитываем количество пересечений
        HashMap<LocalDate, Integer> localDateHashMap = new HashMap<>();
        System.out.println("Входные данные (без учета даты выезда): ");
        inputDates.forEach(personDates -> {
            LocalDate inDate = personDates.get(0);
            LocalDate outDate = personDates.get(1);

            //datesUntil уже убирает дату выезда, это хорошо, потому они не идут в счет дней проживания по постановке задачи
            List<LocalDate> personEveryDate = inDate.datesUntil(outDate).toList();
            System.out.println(personEveryDate);

            personEveryDate.forEach(personDate -> {
                if (localDateHashMap.containsKey(personDate)) {
                    Integer number = localDateHashMap.get(personDate);
                    localDateHashMap.replace(personDate, ++number);
                } else {
                    localDateHashMap.put(personDate, 1);
                }
            });
        });

        Comparator<Integer> byInteger = Integer::compareTo;

        LinkedHashMap<LocalDate, Integer> sortedMap = localDateHashMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(byInteger.reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        //Вывод результата
        System.out.println("Результат: " + sortedMap);
        System.out.println("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");

        System.out.println("Вывести на печать now-birthday во всех TemporalUnit");
        System.out.println("---");

        LocalDate birthDay = LocalDate.of(1996, 2, 24);

        DecimalFormat df = new DecimalFormat("###.###");

        System.out.println("Исходные данные: " + birthDay);
        System.out.println("Секунды: " + birthDay.toEpochSecond(LocalTime.NOON, ZoneOffset.UTC));
        System.out.println("Минуты: " + df.format((double) birthDay.toEpochSecond(LocalTime.NOON, ZoneOffset.UTC) / 60));
        System.out.println("Часы: " + df.format((double) birthDay.toEpochSecond(LocalTime.NOON, ZoneOffset.UTC) / 3600));
        System.out.println("Дни: " + birthDay.toEpochDay());
        System.out.println("Недели: " + ChronoUnit.WEEKS.between(LocalDate.ofEpochDay(0), birthDay));
        System.out.println("Месяцы: " + ChronoUnit.MONTHS.between(LocalDate.ofEpochDay(0), birthDay));
        System.out.println("Года: " + ChronoUnit.YEARS.between(LocalDate.ofEpochDay(0), birthDay));
        System.out.println("Века: " + ChronoUnit.CENTURIES.between(LocalDate.ofEpochDay(0), birthDay));

        System.out.println("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");

        System.out.println("Написать конвертер длин см, мм, нм, дм, м, км, дюймы, мили");
        System.out.println("---");
        Length length = Length.create(3L, LengthUnits.KILOMETERS);
        System.out.println("Длина в нанометрах: " + length.get(LengthUnits.NANOMETERS).toString());
        System.out.println("Длина в дюймах: " + length.get(LengthUnits.INCHES).toString());
        System.out.println("Длина в миллиметрах: " + length.get(LengthUnits.MILLIMETERS).toString());
        System.out.println("Длина в сантиметрах: " + length.get(LengthUnits.CENTIMETERS).toString());
        System.out.println("Длина в дециметрах: " + length.get(LengthUnits.DECIMETERS).toString());
        System.out.println("Длина в метрах: " + length.get(LengthUnits.METERS).toString());
        System.out.println("Длина в километрах: " + length.get(LengthUnits.KILOMETERS).toString());
        System.out.println("Длина в милях: " + length.get(LengthUnits.MILES).toString());

        System.out.println("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");


        System.out.println("Написать код, который бы печатал каждые 5 секунд «tic tac»");
        System.out.println("---");

        Timer timer = new Timer();
        timer.schedule(new ScheduledTask(), 0, 5000);

    }
}
