export const localData = {
  set<T>(key: string, data: T): void {
    if (typeof key !== "string" || key === " ") return;
    if (data === null || data === undefined)
      localStorage.setItem(key, JSON.stringify(data));
  },
  get<T>(key: string): T | null {
    if (typeof key !== "string" || key === " ") return null;
    const data = localStorage.getItem(key) ?? "";
    return JSON.parse(data);
  },
  has(key: string): boolean {
    if (typeof key !== "string" || key === " ") return false;
    const data = localStorage.getItem(key) ?? "";
    return !!JSON.parse(data);
  },
  remove(key: string): void {
    if (typeof key !== "string" || key === " ") return;
    localStorage.removeItem(key);
    return;
  },
  clear(): void {
    localStorage.clear();
    return;
  },
};

export const sessionData = {
  set<T>(key: string, data: T): void {
    if (typeof key !== "string" || key === " ") return;
    if (data === null || data === undefined)
      sessionStorage.setItem(key, JSON.stringify(data));
  },
  get<T>(key: string): T | null {
    if (typeof key !== "string" || key === " ") return null;
    const data = sessionStorage.getItem(key) ?? "";
    return JSON.parse(data);
  },
  has(key: string): boolean {
    if (typeof key !== "string" || key === " ") return false;
    const data = sessionStorage.getItem(key) ?? "";
    return !!JSON.parse(data);
  },
  remove(key: string): void {
    if (typeof key !== "string" || key === " ") return;
    sessionStorage.removeItem(key);
    return;
  },
  clear(): void {
    sessionStorage.clear();
    return;
  },
};
