import { useEffect, useState } from "react";

const useWidows = () => {
  const [windowHeight, setWindowHeight] = useState<number>(window.innerHeight);
  const setHeight = () => {
    setWindowHeight(window.innerHeight);
  };
  useEffect(() => {
    window.addEventListener("resize", setHeight);
    return () => {
      window.removeEventListener("resize", setHeight);
    };
  }, []);
  return windowHeight;
};

export default useWidows;
