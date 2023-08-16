#!/bin/bash

#find $HOME/project/bazel-testlogs/ -type f -name "test.xml" | sed -r "s:/:_:g" | sed -r "s:^[_]:$HOME/tests/:g" > /tmp/.name;
#find $HOME/project/bazel-testlogs/ -type f -name "test.xml" > /tmp/.oname;
#
#exec {fdOName}</tmp/.oname
#exec {fdNName}</tmp/.name
#
#while read -r -u $fdOName lineO && read -r -u $fdNName lineN
#do
#    cut -f8 $lineO > $lineN
#done
#
#rm /tmp/.oname;
#rm /tmp/.name;

cp -a $HOME/project/demo_bazel/resources/. $HOME/tests/
