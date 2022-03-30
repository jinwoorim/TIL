About branch

branch : Instead of working in the original branch, create a new branch and work there. This is similar to the test mode.

# Make a branch

```shell

git branch (branch name)

```
If you make a new branch, it is same with main branch

# Delete a branch

```shell

git branch -d (branch name)

```

# Change the branch

```shell

git checkout (branch name)

```

# Working on the new branch

```shell

1. git checkout (new branch)
2. work something on the new branch
3. git add (filename)
4. git commit
5. git push origin (new branch)
6. git checkout (original branch)
7. git merge (new branch)
8. git add (filename)
9. git commit
10. git push origin (original branch)

```

