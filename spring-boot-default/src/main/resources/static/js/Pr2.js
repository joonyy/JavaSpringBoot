    let isLoggedIn = false;
    let loginData;
    const form = document.getElementById("user-form");
    let formdata;
    function register(){
    if(isLoggedIn === false){
        formdata = {
            name: form.name.value,
            password: form.password.value
        }
        axios.post("/Pr2/register", formdata)
        .then((res)=>{
            console.log(`${res.data}`);
        })
        .catch((err) =>{
            console.log(err);
        });
    }
    }
    function login(){
    if(isLoggedIn===false){
        formdata = {
            name: form.name.value,
            password: form.password.value
        }
        axios.post("/Pr2/login", formdata)
        .then((res)=>{
            if(res.data){
                console.log("로그인 성공!");
                loginData = formdata;
                isLoggedIn = true;
                document.querySelector(".isLoggedIn").textContent = "LoggedIn = true";
                } else {
                console.log("로그인 실패");
                }
        })
        .catch((err) =>{
            console.log(err);
        });
    }
    }
    function updateUser(){
    if(isLoggedIn===true){
        formdata = {
            name: form.name.value,
            password: form.password.value
        }
        if(formdata.password != loginData.password) console.log("비밀번호가 일치하지 않습니다.");
        else{
            axios.put("/Pr2/update", formdata)
            .then((res)=>{
                console.log(`${res.data}`);
            })
            .catch((err) =>{
                console.log(err);
            });
        }
    }else{
        console.log("로그인 정보가 없습니다.");
    }
    }
    function deleteUser(){
        if(isLoggedIn===true){
        isLoggedIn =false;
        document.querySelector(".isLoggedIn").textContent = "LoggedIn = false";
        axios.delete("/Pr2/delete", {data : loginData})
        .then((res)=>{
            console.log(`${res.data}`);
            loginData = {};

        })
        .catch((err) =>{
            console.log(err);
        });
    }else{
        console.log("로그인 정보가 없습니다.");
    }
    }