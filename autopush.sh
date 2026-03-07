
echo "Please enter your commit: "
read message

git add .
git commit -m "${message}"
git push -u origin main