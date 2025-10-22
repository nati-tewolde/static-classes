package com.pluralsight;

public class NameFormatter {

    private NameFormatter() {

    }

    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
       /* if (prefix.isEmpty()) {
            return lastName + ", " + firstName + " " + middleName + ", " + suffix;
        }
        if (middleName.isEmpty()) {
            return lastName + ", " + prefix + " " + firstName + ", " + suffix;
        }
        if (suffix.isEmpty()) {
            return lastName + ", " + prefix + " " + firstName + " " + middleName;
        }
        return lastName + ", " + prefix + " " + firstName + " " + middleName + ", " + suffix;
    }*/

        StringBuilder fullName = new StringBuilder();
        fullName.append(lastName).append(", ");
        if (!prefix.isEmpty()) {
            fullName.append(prefix).append(" ");
        }
        fullName.append(firstName).append(" ");
        if (!middleName.isEmpty()) {
            fullName.append(middleName).append(" ");
        }
        if (!suffix.isEmpty()) {
            fullName.append(suffix);
        }
        return fullName.toString();
    }


    public static String format(String fullName) {
        String suffix = "";
        String[] parts = fullName.split(",");

        if (parts.length > 1) {
            suffix = parts[1];
        }

        String[] nameParts = parts[0].split(" ");

        String prefix = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";

        if (nameParts.length == 2) {
            firstName = nameParts[0];
            lastName = nameParts[1];
        } else if (nameParts.length == 3) {
            firstName = nameParts[0];
            middleName = nameParts[1];
            lastName = nameParts[2];
        } else if (nameParts.length == 4) {
            prefix = nameParts[0];
            firstName = nameParts[1];
            middleName = nameParts[2];
            lastName = nameParts[3];
        }
        return format(prefix, firstName, middleName, lastName, suffix);
    }

}
