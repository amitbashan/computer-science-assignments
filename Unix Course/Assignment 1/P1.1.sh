#!/bin/bash

read -p "Enter first file name: " first_file_name
read -p "Enter second file name: " second_file_name
echo
echo "Beginning of first file $first_file_name"
cat $first_file_name
echo
echo "End of first file $first_file_name"
echo
echo "This is the second file $second_file_name"
cat -n $second_file_name
echo

