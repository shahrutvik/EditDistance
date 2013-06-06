QA Automation Lead - Homework problem
========================================
We anticipate that this problem will take you about 1 hour. We know that this is a significant time committment before a technical phone screen, but we want to ensure that we hire only exceptionally good QA leads and this helps us find them.

Goal: Test a Damerau-Levenshtein distance algorithm implementation. 

Specification: 
DamerauLevenshtein(s1, s2) = 
    The minimum number of "edits" required to transform s1 into s2, where
    one "edit" is either 
        - the addition of a letter, 
        - deletion of a letter
        - replacement of a single letter
        - transposition of two letters (such as 'cehgg' instead of 'chegg')
    

Example: (from Wikipedia)
DamerauLevenshtein('kitten', 'sitting') = 3
    [ replace k with s, replace e with i, add g ]
    
Code available here: 
git clone from
https://github.com/CheggEng/EditDistance

Your objective:
Write a test suite in JUnit that tests this function against the spec.
gov.nih.cit.editdistance.DamerauLevenshteinDistance.computeLevensteinDistance(String s, String t)

Try to think of all the cases that might be troublesome. It's ok to look at the source code (white-box test),
but it is not required.

We forked this particular implementation off of some random repository on github. 
We don't know if it is perfectly correct or not.
If you find any errors, that is great! Your test suite should run but the relevant test should fail.
If you don't find errors, then obviously it should pass.

Submission:
Zip the project folder and email it to the recruiter

