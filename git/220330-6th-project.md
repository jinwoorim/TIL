# If you want to change name

```shell
$ git mv {original file name} {new file name}
```
If you write $ mv {original file name} {new file name}, git doesn't think it's changed, but thinks the original file has been deleted.


# If you want to go back to before the last action

```shell
$ git restore {file name}
```

# If you want to go back to last commit status

```shell
$ git restore .
```

# If you want to cancel the file added to the stage

```shell
$ git reset HEAD {file name} 
```
Head means the latest.

# If you want to cancel the committed file and rewrite commit

```shell
$ git commit --amend
```
# If you want to go back to several levels of commit

```shell
$ git --no commit HEAD~{number}
```
