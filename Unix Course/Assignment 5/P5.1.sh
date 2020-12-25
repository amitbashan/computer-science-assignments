#!/bin/bash

string=$1
character="${string:${#str}-2:1}"
result=${string//[^$character]}

echo "${#result}"
