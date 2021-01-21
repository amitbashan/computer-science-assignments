#!/usr/bin/awk -f

BEGIN {
	score_count = 0
	print "__________________________________"
	print "| name |  QA   |  test  |  final |"
}

{
	split($0, splitted)

	if (NR > 1) {
		if (splitted[length(splitted)] > 6) {
			for (x = 3; x < length(splitted); ++x) {
        		total_score += $x
        		++score_count
        	}

        	print "__________________________________"
        	printf "| %s.%s. | %.2f  |  %.2f  |  %.2f  |\n", substr($1, 0, 1), substr($2, 0, 1), total_score / score_count, splitted[length(splitted)], 0.2 * total_score / score_count + 0.8 * splitted[length(splitted)]
		}
	}

	total_score = 0
	score_count = 0
}

END {
	print "__________________________________"
}
