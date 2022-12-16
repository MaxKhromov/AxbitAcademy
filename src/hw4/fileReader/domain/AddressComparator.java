package hw4.fileReader.domain;

import java.util.Comparator;

public class AddressComparator {

    public int compareStringWithNumbers(String str1, String str2) {
        String numbersAsString1 = str1.replaceAll("[^0-9]", "");
        String numbersAsString2 = str2.replaceAll("[^0-9]", "");

//            String symbols1 = house1.replaceAll("[^A-Za-zА-Яа-я]", "");
//            String symbols2 = house2.replaceAll("[^A-Za-zА-Яа-я]", "");
        String symbols1 = str1.replaceAll("\\d", "");
        String symbols2 = str2.replaceAll("\\d", "");

        if (!str1.equals(str2)) {
            if (!(symbols1.isEmpty() && symbols2.isEmpty())) {
                if (symbols1.equals(symbols2)) {
                    if (!(numbersAsString1.isEmpty() && numbersAsString2.isEmpty())) {
                        int numbers1 = Integer.parseInt(numbersAsString1);
                        int numbers2 = Integer.parseInt(numbersAsString2);
                        return numbers1 - numbers2;
                    } else {
                        return 0;
                    }
                } else {
                    return symbols1.toUpperCase().compareTo(symbols2.toUpperCase());
                }
            }
        }
        return 0;
    }

    public static class AddressComparatorByHouse implements Comparator<Address> {

        @Override
        public int compare(Address add1, Address add2) {
            AddressComparator addressComparator = new AddressComparator();
            String house1 = add1.getHouse();
            String house2 = add2.getHouse();
            return addressComparator.compareStringWithNumbers(house1, house2);
        }

    }

    public static class AddressComparatorByFlat implements Comparator<Address> {

        @Override
        public int compare(Address add1, Address add2) {
            AddressComparator addressComparator = new AddressComparator();
            String house1 = add1.getFlat();
            String house2 = add2.getFlat();
            return addressComparator.compareStringWithNumbers(house1, house2);
        }

    }
}
