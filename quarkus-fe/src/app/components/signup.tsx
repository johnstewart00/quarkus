"use client";

import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { signup } from "@/presenter/authPresenter";
import { useRouter } from "next/navigation";
import { useState } from "react";

export const SignUp = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const router = useRouter();

  const handleSignUp = async () => {
    const success = await signup(email, password, name);
    if (success) {
      router.push("/landing");
    }
  };
  return (
    <div>
      <div className="text-2xl my-5">Sign Up</div>
      <div className="flex flex-col gap-4">
        <Input
          type="text"
          placeholder="Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <Input
          type="text"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <Input
          type="text"
          value={password}
          placeholder="Password"
          onChange={(e) => setPassword(e.target.value)}
        />
        <Button className="w-min" onClick={handleSignUp}>
          Sign Up
        </Button>
      </div>
    </div>
  );
};
