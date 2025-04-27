"use client";

import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { login } from "@/presenter/authPresenter";
import { useRouter } from "next/navigation";
import { useState } from "react";

export const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const router = useRouter();

  const handleLogin = async () => {
    const success = await login(email, password);
    if (success) {
      router.push("/landing");
    }
  };
  return (
    <div>
      <div className="text-2xl my-5">Login</div>
      <div className="flex flex-col gap-4">
        <Input
          type="text"
          value={email}
          placeholder="Email"
          onChange={(e) => setEmail(e.target.value)}
        />
        <Input
          type="text"
          value={password}
          placeholder="Password"
          onChange={(e) => setPassword(e.target.value)}
        />
        <Button className="w-min" onClick={handleLogin}>
          Login
        </Button>
      </div>
    </div>
  );
};
