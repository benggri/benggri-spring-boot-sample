echo $(pwd) && \
ssh -T git@github.com && \
git config push.recurseSubmodules check && \
git config push.recurseSubmodules on-demand && \
git pull && \
git submodule foreach git checkout develop && \
git submodule foreach git pull && \
./gradlew clean && \ 
./gradlew build --refresh-dependencies && \
echo DONE