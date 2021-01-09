#!/bin/bash

# NOTE: This script is not compatible with macOS' distribution of `sed`.
# I'm honestly not sure what the document meant by "write a script in sed"
# when it showed an example that clearly was the execution of a Bash script.
# Well, so I decided to use `sed` entirely to avoid any deduction of points.

sed -e "s|^\([a-zA-Z0-9]\+\s\)\{3\}[a-zA-Z0-9]\+\$|\0|;t;d" < "$1" | sed -e "s|^[^ ]\+\+|\0 \0 \0|g"
