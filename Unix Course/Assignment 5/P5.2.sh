#!/bin/bash

string=$1
result=$(echo "$string" | fold -w 1 | uniq -c | sort -bnr)
read -r -a array <<< "$result"

echo "${array[0]}"
