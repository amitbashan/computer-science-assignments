#!/bin/bash

echo -n "Enter file or directory names: "
read names

for name in $names; do
	if [[ -d $name ]]; then
    	echo "$name is a directory"
	elif [[ -f $name ]]; then
    	echo -n "$name is a regular file of size "
		echo $(wc -c < $name)
	else
    	echo "$name is not a file or directory"
	fi
done
