#!/bin/bash

echo -n "Enter number: "
read number

highest_number=$(($number*2))
space_count=0

for ((star_count = $highest_number; star_count >= 2; star_count -= 2)); do
	for ((x = 0; x < $space_count; ++x)); do
		echo -n " "
	done

	for ((x = 0; x < $star_count; ++x)); do
		echo -n "*"
	done

	echo
	((++space_count))
done

((space_count -= 2))

for ((star_count = 4; star_count <= $highest_number; star_count += 2)); do
	for ((x = $space_count; x > 0; --x)); do
		echo -n " "
	done

	for ((x = $star_count; x > 0; --x)); do
		echo -n "*"
	done

	echo
	((--space_count))
done
