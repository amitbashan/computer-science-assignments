#!/bin/bash

#
# Ugly method, I know.
# 
# Explanation:
# 
# Use "find" command (non-recursively) to get all
# files with the extension "txt" and execute "wc -w"
# on them to get their word count, then sort them
# from most words to least words, and
# only get the top 3 text files (assuming there are even atleast 3 text files).
# 
# Why do I increment the index by 2
# in the for loop? Because the array
# contains the file names every other
# iteration, so it would look like this:
#
#	2 two_words.txt 6 six_words.txt
# 

files=`find . -maxdepth 1 -type f -name "*.txt" -exec wc -w {} + | sort -rn | tail -n +2 | head -n 3`
array=($files)

for ((i = 1; i < ${#array[@]}; i += 2)); do
	rm ${array[i]}
done
