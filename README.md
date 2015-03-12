# Introduction to data-in
The purpose of `data-in` is to read all the lines from a text file and return the file's contents as a Clojure value in a standardized manner.

# Specification
###Takes:
  + `Filename`

###Assumes:
  + a space delimited text file

###Returns:
  + Vector **[L<sub>1</sub>,L<sub>2</sub>,...L<sub>n</sub>]** where **L<sub>i</sub>**:
    + represents a line in `Filename`
	+ is a vector
	+ contains EDN values

# Example:
If `my-file.txt` contains:

    3 9
    5 4
    6 5
    3 2

then `(data-in "./my-file.txt")` returns:

`[[3 9] [5 4] [6 5] [3 2]]`

# Comments
To avoid executing arbitrary code, `data-in` reads values from files with `clojure.edn/read-string`.

The input is not read lazily.
