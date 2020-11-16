#!/bin/bash

read -p "Enter number: " number
echo "I went to sleep for $number seconds at:"
date
sleep $number
echo "I woke up at:"
date
echo

