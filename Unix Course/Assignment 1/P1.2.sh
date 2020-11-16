#!/bin/bash

read -p "Enter first number: " first_number
read -p "Enter second number: " second_number
read -p "Enter third number: " third_number

max_number=$first_number

for number in $second_number $third_number; do
	if [ "$number" -gt "$max_number" ]; then
		max_number=$number;
	fi
done

echo "The maximum of the three numbers $first_number $second_number $third_number is: $max_number"
echo

