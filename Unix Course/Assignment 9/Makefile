SRC := $(wildcard *.sh)
OUTPUTS := $(patsubst %.sh,outputs/%.output,${SRC})
DIFFS := $(patsubst %.sh,%,${SRC})

.PHONY: clean

test: outputs ${OUTPUTS} ${DIFFS}

%: outputs/%.output
	$(eval RESULT=$(shell diff $< $(patsubst outputs/%.output,expected/%.expected,$<)))
	@if [ -z "$(RESULT)" ]; then \
		echo "$(patsubst outputs/%.output,%,$<) successful"; \
	else \
		echo "$(patsubst outputs/%.output,%,$<) mistakes:"; \
		echo "$(RESULT)"; \
	fi

clean:
	@rm -r outputs

outputs:
	@mkdir -p outputs

outputs/%.output: %.sh
	@./$< $(shell cat $(patsubst %.sh,inputs/%.input,$<)) > $@
