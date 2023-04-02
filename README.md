
# Strong Password Checker

The PasswordChecker class asks for a password as input and returns an integer value that represents the minimum changes needed in order to make a password strong. The minimum changes are calculated based on various factors, such as the minimum, maximum length of the password, the number of different types of characters used, and the presence of repeating characters.




## Documentation

The makePasswordStrong method uses the following steps to calculate the minimum changes needed to make a password strong:

* The length of the password is calculated using the length() method.

* The password is converted into an array of characters using the toCharArray() method.

* A boolean array called changesNeeded is created with three elements. Each element represents whether a lowercase letter, an uppercase letter, and a digit are present in the password.

* A loop is used to iterate through each character in the password array. If a lowercase letter, uppercase letter, or digit is found, the corresponding element in the changesNeeded array is set to true.

* The number of changes (regarding the 3 types of characters)needed to make the password stronger is calculated by adding up the number of elements in the changesNeeded array that are false.

* A loop is used to iterate through each character in the password array. If a character is the same as the previous character, a counter called repeating is incremented. If a different character is found or the end of the password is reached, the repeating counter is checked. If the counter is greater than two (meaning that a sequance of at least 3 has been found), it is divided by three to calculate the number of changes needed to make the password stronger (aaa -> aab -> 1 change, aaaaaa -> aabaab -> 2 changes). If the sequence is divisible by three, we increase the oneRemoval counter, which represents that we could decrease the number of changes needed for that sequance with one removal , otherwise if two removals are needed to decrease the number of changes, we increase the twoRemoval counter.

* If the length of the password is less than 20, the maximum of the repeating character changes, the type changes and the length changes are returned, since we can fix these issues at the same time.

* If the length of the password is longer or equal to 20:
    * we define a variable called toDelete that represents the number of characters that the password exceeds.

    * The first line of code subtracts the number of repeating characters that can be deleted with one change. This is calculated by finding the minimum of toDelete and oneRemoval (which represents the number of groups of repeating characters that have a length that is a multiple of 3)

    * The second line of code subtracts the number of repeating characters that can be deleted with two changes. This is calculated by finding the minimum of toDelete - oneRemoval (which represents the number of characters that remain after deleting the characters that can be deleted with one change) and twoRemoval (which represents the number of groups of repeating characters that have a length that is one more than a multiple of 3), and then dividing by 2 to round down to the nearest integer.

    * The third line of code subtracts the number of repeating characters that can be deleted with three changes. This is calculated by finding the maximum of toDelete - oneRemoval - 2 * twoRemoval (which represents the number of characters that remain after deleting the characters that can be deleted with one or two changes) and 0 (to avoid negative values), and then dividing by 3 to round down to the nearest integer.

    * The final result is the sum of the number of changes required to fix the length of the password, plus the maximum of changes required to fix repeating characters and the missing types.


## Purpose

UMT Software technical test