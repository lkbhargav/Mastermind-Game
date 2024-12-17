.PHONY: build
build:
	ant build

.PHONY: run
run: build
	java -jar build/MasterMindProject.jar

.PHONY: clean
clean:
	ant clean

.PHONY: compile
compile:
	ant compile

.PHONY: help
help:
	@echo "1. Install Ant before you can run the project\n2. Then run the clean, compile, build, and run commands as you like."