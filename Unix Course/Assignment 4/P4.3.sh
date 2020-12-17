#!/bin/bash

IFS=$'\n'
file_name=$1
i=0

for line in $(cat $file_name); do
	if ! ((i % 2)); then
		echo $line | tr 6-9 a-d
	else
		echo $line | tr a-z A-Z
	fi

	((++i))
done
