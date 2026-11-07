import useWidows from "@/hooks/useWidows";
import bgImage from "@/assets/Background/primary-bg.png"
import React from "react";

const Login = () => {
  const windowsHeight = useWidows();
  return (
    <main
      style={{
        height: windowsHeight,
        backgroundImage:`url(${bgImage})`
      }}
      className="bg-cover"
    ></main>
  );
};

export default Login;
