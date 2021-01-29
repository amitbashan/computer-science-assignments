#!/bin/bash

# Won't output correct results on macOS' distribution of `sed`.
# Use GNU sed.

# Pipes are not allowed. Hence the use of redirection.

sed -e "s|[0-9].*[0-9]|\0|;t;d" "$1" >| tmp
sed -e "s/^\([a-zA-Z0-9]\+\ *[a-zA-Z0-9]\+\).*/\1/" < tmp
rm tmp
