import { Login } from "./components/login";
import { SignUp } from "./components/signup";

export default async function Home() {
  return (
    <div className="grid grid-cols-2 gap-4 ml-4 mt-4">
      <Login />
      <SignUp />
    </div>
  );
}
