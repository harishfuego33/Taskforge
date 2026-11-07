import { localData } from "@/hooks/useStorage";
import { LOCAL_KEYS } from "@/lib/constant";
import React, { createContext, ReactNode, useContext, useEffect, useState } from "react";

type Theme = "dark" | "light" | "system";

interface ThemeProviderProps {
  children: ReactNode;
  defaultTheme?: Theme;
}

interface ThemeContextProps {
  theme: Theme;
  setTheme: (theme: Theme) => void;
}

const ThemeContext = createContext<ThemeContextProps | undefined>(undefined);

export const ThemeProvider: React.FunctionComponent<ThemeProviderProps> = ({
  children,
  defaultTheme = "system",
}) => {
  const [theme, setTheme] = useState<Theme>(
    (): Theme => localData.get<Theme>(LOCAL_KEYS.theme) || defaultTheme,
  );

  useEffect(() => {
    const root = document.documentElement;
    root.classList.remove("light", "dark");
    const activeTheme: Theme =
      theme === "system"
        ? window.matchMedia("(prefers-color-scheme:dark)").matches
          ? "dark"
          : "light"
        : theme;
    root.classList.add(activeTheme);
  }, [theme]);

  const changeTheme = (newTheme: Theme) => {
    localData.set<Theme>(LOCAL_KEYS.Theme, newTheme);
    setTheme(newTheme);
  };
  <ThemeContext.Provider
    value={{
      theme,
      setTheme: changeTheme,
    }}
  >
    {children}
  </ThemeContext.Provider>;
};

export const useTheme = ()=>{
    const context = useContext(ThemeContext);
    if(!context){
        throw new Error("useTheme must be with in theme provider")
    }
    return context;         
}

