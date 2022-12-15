package hw4.fileReader.domain;

import java.util.Comparator;

public class AddressComparator {

    public class AddressComparatorByHouse implements Comparator<Address> {
        int compareResult = 0;

        @Override
        public int compare(Address add1, Address add2) {

            String house1 = add1.getHouse();
            String house2 = add2.getHouse();

            String numbersAsString1 = house1.replaceAll("[^0-9]", "");
            String numbersAsString2 = house2.replaceAll("[^0-9]", "");

            String symbols1 = house1.replaceAll("[^A-Za-zА-Яа-я]", "");
            String symbols2 = house2.replaceAll("[^A-Za-zА-Яа-я]", "");

            if (!house1.equals(house2)) {
                if (!(symbols1.isEmpty() && symbols2.isEmpty())) {
                    if (symbols1.equals(symbols2)) {
                        compareResult = 0;
                        if (!(numbersAsString1.isEmpty() && numbersAsString2.isEmpty())) {
                            int numbers1 = Integer.parseInt(numbersAsString1);
                            int numbers2 = Integer.parseInt(numbersAsString2);
                            return numbers1 > numbers2 ? 1 : 0;
                        }
                    } else {
                        return symbols1.toUpperCase().compareTo(symbols2.toUpperCase());
                    }
                }
            }
            return 0;
        }

    }
}
