# git clone

## Make repo first on the github, after local (top down)

```shell
0. We make repo onthe github. And we write git clone (repo address) on the dev

1. We fix file or something on git
2. Write $git status, then you can show comment like changes not staged for commit
3. $ git add (file name)
4. Write $git status, you can show comment like changes to be committed with green 
5. $ git status, then show nothing to commit working tree clean
6. $ git push origin main.
7. The End. you can show final project in the git hub
```


# git init

## Make dir first on the git (bottom up)

```shell

1. $ mkdir second-repo
2. $ cd second-repo
3. $ git init
 //after creating remote repo on github,
4. $ git remote add mask{repo_url}

 // After doing some work,

5. $ git add{filename}
6. $ git commit
7. $ git branch -M main
8. $ git push -u mask main

```

