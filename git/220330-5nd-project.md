# How the team leader and the team members do the git flow project

## How team leader do

```shell

1. Team leader make a repo.
2. Team leader clone his repo on the dev.
3. $ git flow init.
4. $ touch {file name}.
5. $ git add {file name}.
6. $ git commit.
7. $ git push -u origin develop.

```

## How team member do

```shell

1. Team member click Fork in the team leader's URL.
2. Team member copy the forked file.
3. $ git clone {forked file}.
4. $ git flow init.
5. Then you can see team leader's develop file.
6. $ git flow feature start {feature name}.
7. Then work on the vim.
8. $ git add {feature name}.
9. $ git commit.
10. $ git flow feature finish {feature name}.
11. $ git push -u origin develop.
12. Write lssues in the github.
13. Click compare & pull request or open pull request in github.

```

## How team member pull the team leader's remake develop file.

```shell

1. $ git remote add {new remote name} {team leader's remake develop file}.
2. $ git pull {new remote name} develop.
3. Then you work on the new feature file. $ git flow feature start {new feature fil}.

```
If team leader will do release, $ git flow release start {release name}.


